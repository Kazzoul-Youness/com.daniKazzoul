package daniKazzoul.components;

import javax.swing.*;
import java.util.List;

public class ProgressFavoris extends SwingWorker<Void, Integer> {
    private static final long LOOP_LENGTH = 85000000;

    public JProgressBar progress;

    private final JTextArea message;
    private final JButton favorisSecurite;
    private final JButton btnOk;

    public ProgressFavoris(JProgressBar progress, JTextArea message, JButton favorisSecurite, JButton btnOk) {
        this.progress = progress;
        this.message = message;
        this.favorisSecurite = favorisSecurite;
        this.btnOk = btnOk;
    }
    @Override
    public Void doInBackground() {
        for (long i = LOOP_LENGTH; i > 0; i--) {
            final int progr = (int) ((1000L * (LOOP_LENGTH - i)) / LOOP_LENGTH);
            publish(progr);
        }
        return null;
    }

    @Override
    protected void process(List<Integer> chunks) {
        progress.setValue(chunks.get(chunks.size() - 1));
        super.process(chunks);
    }
    @Override
    public void done() {
        //progress.setValue(1000);
        progress.setValue(0);
        System.out.println(" Favoris enregistré ");
        message.setText("\n Appuyer sur (Ok), \n\n pour sortir vers le menu");
        favorisSecurite.setEnabled(true);
        btnOk.setEnabled(true);
    }


}























//package daniKazzoul.components;
//
//import javax.swing.*;
//
//    public class ComposantProgressBar extends Thread {
//        private static int DELAY = 10;
//        JProgressBar progressBar;
//        public ComposantProgressBar(JProgressBar bar) {
//            progressBar = bar;
//        }
//        public void run() {
//
//            //for (int i = 0; i < 2000; i++) {
//            int value = progressBar.getValue();
//            do {
//                try {
//                    progressBar.setValue(value);
//                    Thread.sleep(DELAY);
//                } catch (InterruptedException ignoredException) {
//                }
//
//                value = value + 5 ;
//                //System.out.println("v = "+progressBar.getValue());
//            } while (value <= 1000);
//
//            if (progressBar.getValue() >= 1000) {
//                progressBar.setValue(0);
//            }
//        }
////
////        public int niveauProgBar(){
////            return progressBar.getValue();
////        }
//
//    }

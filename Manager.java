import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

    public class Manager {

        JFrame fr = new JFrame("PRG");
        int lastTile = 0;

        HashMap<Integer, JButton> btn = new HashMap<Integer, JButton>();
        void vyplnenimapy() {
            for (int i = 0; i < 9; i++) {
                btn.put(i + 1, new JButton(""));
            }
        }

        Color[] col = {Color.blue, Color.cyan, Color.black, Color.gray, Color.green, Color.lightGray};

        void policka() {
            fr.setSize(200, 200);
            fr.setResizable(false);
            fr.setLayout(new GridLayout(3, 3));

        }

        void nastaveniobjektu () {

            for (JButton bt : btn.values()) {
                bt.addActionListener(this::actionPerformer);
                fr.add(bt);
            }
            fr.setVisible(true);
        }

        void actionPerformer(ActionEvent e) {
            scramble(keys(btn, (JButton)e.getSource()));
        }

        void scramble (Integer n) {
            int x = (int) (Math.random() * btn.size());
            int y = (int) (Math.random() * col.length);

            if (n != lastTile) {
                btn.get(n).setBackground(Color.red);
                for (int i = 1; i <= btn.size(); i++) {
                    if (i != n) {
                        btn.get(i).setBackground(col[y]);
                    }
                }
            }
            lastTile = n;
        }

        public <K, V> K keys(Map<K, V> map, V value) {
            return map
                    .entrySet()
                    .stream()
                    .filter(entry -> value.equals(entry.getValue()))
                    .map(Map.Entry::getKey)
                    .findFirst().get();
        }
    }

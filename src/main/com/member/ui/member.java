package main.com.member.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class member extends JFrame {
    public member() {
        setTitle("Search Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        // Create sample search results
        List<String> searchResults = new ArrayList<>();
        searchResults.add("Result 1");
        searchResults.add("Result 2");
        searchResults.add("Result 3");
        searchResults.add("Result 4");
        searchResults.add("Result 5");

        // Create a DefaultListModel to hold search results
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String result : searchResults) {
            listModel.addElement(result);
        }

        // Create a JList with the DefaultListModel
        JList<String> resultList = new JList<>(listModel);
        resultList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Enable multi-selection
        resultList.setCellRenderer(new CheckBoxListCellRenderer());
        resultList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = resultList.locationToIndex(e.getPoint());
                if (index != -1) {
                    resultList.setSelectionInterval(index, index);
                }
            }
        });
        // Wrap the JList in a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(resultList);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private static class CheckBoxListCellRenderer extends JCheckBox implements ListCellRenderer<String> {

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            setText(value);
            setSelected(isSelected);
            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            return this;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            member demo = new member();
            demo.setVisible(true);
        });
    }
}

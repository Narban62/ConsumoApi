package ec.edu.uce.view;

import ec.edu.uce.controller.MarsPhotosFetcher;
import ec.edu.uce.model.MarsPhoto;
import ec.edu.uce.service.MarsPhotosTableModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.List;

public class MarsPhotosPanel extends JPanel {
    private final JButton fetchButton;
    private final JTable photosTable;
    private final MarsPhotosTableModel tableModel;

    private final JTextField cameraNameField;
    private final JFormattedTextField dateField;

    private final JPanel imagePanel;
    private final JLabel urlLabel;
    private final JLabel imageLabel;

    public MarsPhotosPanel() {
        setLayout(new BorderLayout());

        fetchButton = new JButton("Fetch Photos");
        fetchButton.addActionListener(e -> fetchPhotos());

        photosTable = new JTable();
        tableModel = new MarsPhotosTableModel(null);
        photosTable.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(photosTable);

        cameraNameField = new JTextField(20);
        dateField = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
        dateField.setColumns(20);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Camera:"));
        controlPanel.add(cameraNameField);
        controlPanel.add(new JLabel("Date (yyyy-MM-dd):"));
        controlPanel.add(dateField);
        controlPanel.add(fetchButton);

        imagePanel = new JPanel(new BorderLayout());
        urlLabel = new JLabel();
        imageLabel = new JLabel();
        imagePanel.add(urlLabel, BorderLayout.NORTH);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, imagePanel);
        splitPane.setDividerLocation(300);

        add(controlPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);

        photosTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                showSelectedImage();
            }
        });
    }

    private void fetchPhotos() {
        String cameraName = cameraNameField.getText();
        String date = dateField.getText();

        if (date == null || date.trim().isEmpty()) {
            System.out.println("Date is empty. Please enter a valid date.");
            return;
        }

        List<MarsPhoto> photos = MarsPhotosFetcher.fetchPhotos(cameraName, date);
        for (MarsPhoto photo : photos) {
            System.out.println(photo.getImg_src());
        }
        tableModel.setPhotos(photos);
        tableModel.fireTableDataChanged();
    }

    private void showSelectedImage() {
        int selectedRow = photosTable.getSelectedRow();
        if (selectedRow >= 0) {
            MarsPhoto photo = tableModel.getPhotos().get(selectedRow);
            urlLabel.setText(photo.getImg_src());

            try {
                URI uri = new URI(photo.getImg_src());

                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(uri);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error loading image or opening URL: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}

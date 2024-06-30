package ec.edu.uce.service;


import ec.edu.uce.model.MarsPhoto;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MarsPhotosTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Camera", "Date", "Image URL"};
    private List<MarsPhoto> photos;

    public MarsPhotosTableModel(List<MarsPhoto> photos) {
        this.photos = photos;
    }

    @Override
    public int getRowCount() {
        return photos != null ? photos.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MarsPhoto photo = photos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return photo.getId();
            case 1:
                return photo.getCamera().getName();
            case 2:
                return photo.getEarth_date();
            case 3:
                return photo.getImg_src();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public List<MarsPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<MarsPhoto> photos) {
        this.photos = photos;
    }
}

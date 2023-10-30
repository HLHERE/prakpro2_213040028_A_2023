/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas07;

/**
 *
 * @author hayka
 */
import javax.swing.table.*;// Import semua class dari javax.swing.table
import java.util.ArrayList;// Import class ArrayList dari java.util
import java.util.List;// Import class List dari java.util

public class TugasPertemuan07 extends AbstractTableModel {
    private String[] columnNames = {"Nama", "Nomor-HP", "jenis-kelamin","Alamat"};
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    
     // fungsi untuk tambah coloumn
    public int getColumnCount() {
        return columnNames.length;// mengembalikan ukuran array
    }
    // Fungsi untuk tambah jumlah baris
    public int getRowCount() {
        return data.size(); //mengembalikan data dari arraylist
    }
    
    // Fungsi untuk mendapatkan nama dari kolom yang dipilih dari parameter
    public String getColumnName(int col) {
        return columnNames[col]; // mengembalikan elemen coloum dnegan index
    }
    
    // Fungsi untuk mendapatkan nilai sari baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        List<String> rowItem = data.get(row); // mengambil sebuah List dari data pada indeks row dan menyimpannya dalam variabel rowItem
        // mengembalikan elemen rowItem dari index col
        return rowItem.get(col);
    }
    
    public boolean isCellEditable(int row, int col) { 
        // Kembalikan nilai false
        return false;
    }
    
    // Method untuk menambah nilai ke table
    public void add(ArrayList<String> value) {
        // Menambahkan input user ke ArrayList data
        data.add(value);
        // Menambahkan elemen-elemen ArrayList data ke table
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    // method untuk Menghapus nilai ke table
    public void remove(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex,rowIndex);
    }
    public ArrayList<String> getDataAt (int rowIndex) {
        if(rowIndex >= 0 && rowIndex < data.size()) {
            return data.get(rowIndex);
        }
        return null;
    }
    public void update(int rowIndex, ArrayList <String> updatedData){
        if (rowIndex >= 0 && rowIndex < data.size()) {
            data.set(rowIndex,updatedData);
            
            fireTableRowsUpdated(rowIndex ,rowIndex);
        }
    }
    
     public void clearData() {
        int size = data.size();
        data.clear();
        fireTableRowsDeleted(0,size - 1);
     }
}


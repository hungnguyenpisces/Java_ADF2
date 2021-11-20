package BT_File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DanhBaDao {
    private static final String Danhba_File_Name = "danhba.txt";

    public void write(List<DanhBa> listDanhba){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(new File(Danhba_File_Name));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listDanhba);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    public List<DanhBa> read(){
        List<DanhBa> listDanhba = new ArrayList<DanhBa>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(Danhba_File_Name));
            ois = new ObjectInputStream(fis);
            listDanhba = (List<DanhBa>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return listDanhba;
    }
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os){
        if(os == null){
            try {
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

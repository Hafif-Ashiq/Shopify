import java.io.*;
import java.util.ArrayList;

public class fileO<T> {

    public void writeToFile(T obj) {
        try {
            File f = null;
            ObjectOutputStream oos;

            // Checking kind of object to create that filr
            if (obj instanceof loginCredentials) {
                f = new File("Files\\LoginInformation.ser");
            } else if (obj instanceof Categories1) {
                f = new File("Files\\Categories.ser");
            }

            // Creating output Stream
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                // f.createNewFile();
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
            }

            // Writing downcasted object in respective files

            if (obj instanceof loginCredentials) {
                loginCredentials l = (loginCredentials) obj;
                oos.writeObject(l);
                System.out.println("written");
            } else if (obj instanceof Categories1) {
                Categories1 c = (Categories1) obj;
                oos.writeObject(c);
                System.out.println("Written Categories");

            }

            oos.close();
        } catch (IOException e) {
            System.out.println("Unable to Write in File !!");
        }

    }

    public ArrayList<loginCredentials> getInArrayLogins(){
        ArrayList<loginCredentials> array = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Files\\LoginInformation.ser"));

            while (true){
                loginCredentials l = (loginCredentials) ois.readObject();
                array.add(l);
            }


        }catch (EOFException e){
            if(ois!= null){
                try {
                    ois.close();
                } catch (IOException t) {
                }
            }
        }
        catch (IOException e){

        }
        catch (ClassNotFoundException e){

        }
        finally{
            if(ois!= null){
                try {
                    ois.close();
                } catch (IOException t) {
                }
            }   
        }
        return array;
    }

    public ArrayList<Categories1> getInArrayCategories(){
        ArrayList<Categories1> array = new ArrayList<>();
        ObjectInputStream ois = null;
        // ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(new File("Files")));
        try {
            ois = new ObjectInputStream(new FileInputStream("Files\\Categories.ser"));

            while (true){
                Categories1 l = (Categories1) ois.readObject();
                array.add(l);
            }


        }catch (EOFException e){
            if(ois!= null){
                try {
                    ois.close();
                } catch (IOException t) {
                }
            }
        }
        catch (IOException e){

        }
        catch (ClassNotFoundException e){

        }
        finally{
            if(ois!= null){
                try {
                    ois.close();
                } catch (IOException t) {
                }
            }
        }
        return array;
    }


    public void update(T obj) {
        ArrayList<Categories1> c = getInArrayCategories();
        ArrayList<loginCredentials> l  = getInArrayLogins();
        if (obj instanceof Categories1) {

            for (int i = 0; i < c.size(); i++) {
                Categories1 c1 = (Categories1) obj;
                if (c.get(i).getName().equals(c1.getName())) {
                    System.out.println("Found");
                    c.set(i, c1);
                }
            }
            File f = new File("Files\\Categories.ser");
            System.out.println(f.delete());
            for (int i = 0; i < c.size(); i++) {
                writeToFile((T) c.get(i));
            }
            // System.out.println("updated ");
        } else if (obj instanceof loginCredentials) {

            // System.out.println(l.size());
            for (int i = 0; i < l.size(); i++) {
                loginCredentials l1 = (loginCredentials) obj;
                // System.out.println(l.get(i).getEmail() + "    " + l1.getEmail());
                if (l.get(i).getEmail().equals(l1.getEmail())) {
                    System.out.println("Found");
                    l.set(i, l1);
                }
            }
            File f = new File("Files\\LoginInformation.ser");
            System.out.println(f.delete());
            for (int i = 0; i < l.size(); i++) {
                writeToFile((T) l.get(i));
            }
            // System.out.println("updated ");
        }

    }

    public void deleteCategory(int i) {
        ArrayList<Categories1> c = null;
        c = getInArrayCategories();
        c.remove(i);

        File f = new File("Files\\Categories.ser");
        System.out.println(f.delete());
        for (int in = 0; in < c.size(); in++) {
            writeToFile((T) c.get(in));
        }
        // System.out.println("updated ");
    }

    public boolean nameCategoryExists(String name) {
        ArrayList<Categories1> c = null;
        c = getInArrayCategories();

        for (int in = 0; in < c.size(); in++) {
            if (c.get(in).getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public <T extends loginCredentials> loginCredentials searchEmail(String n) {
        File f = new File("Files\\LoginInformation.ser");
        if (f.exists()) {
            ObjectInputStream ois = null;
            try {

                ois = new ObjectInputStream(new FileInputStream("Files\\LoginInformation.ser"));
                while (true) {

                    Object o = (Object) ois.readObject();
                    if (o instanceof loginCredentials) {
                        // System.out.println("Here");
                        loginCredentials s = (loginCredentials) o;
                        if (s.getEmail().equals(n)) {
                            return s;

                        }

                    }
                }
            } catch (EOFException e) {
                try {
                    ois.close();
                } catch (IOException t) {
                }
                // System.out.println("Student Not Found");
                return null;
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            }
            finally {
                if(ois!= null){
                    try {
                        ois.close();
                    } catch (IOException t) {
                    }
                }
                // System.out.println("Student Not Found");

            }
        }

        return null;
    }

}

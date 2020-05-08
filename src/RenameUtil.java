import java.io.File;
import java.io.IOException;

public class RenameUtil {

    public static void main(String[] args) throws IOException {

        String path = "C:/temp";

        renameFiles(path);

    }

   public static void renameFiles(String path)
    {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles)
        {

            if(file.isDirectory())
            {
                File[] currentDirectory = file.listFiles();
                String[] presentDirectory = currentDirectory[0].getAbsolutePath().split("\\\\");
                String newPath = path+"//"+presentDirectory[2];

                File bwtFolder = new File(newPath);
                File[] currentListOfFiles = bwtFolder.listFiles();

                for (File currentFile : currentListOfFiles)
                {
                    String currentFileName1 = currentFile.getName();
                    String[] currentFileNameParts = currentFileName1.split("\\.");
                    String newFileName = currentFileNameParts[0]+".mp4";
                    File newPaths = new File(newPath+"/"+newFileName);
                    currentFile.renameTo(newPaths);
                }
            }


        }
    }
}

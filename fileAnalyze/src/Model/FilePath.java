/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author THANH HUYEN
 */
public class FilePath {
    private String allPath;
    private String path;
    private String fileName;
    private String extension;
    private String disk;
    private String folders;

    public FilePath() {
    }

    public FilePath(String path, String fileName, String extension, String disk, String folders) {
        this.path = path;
        this.fileName = fileName;
        this.extension = extension;
        this.disk = disk;
        this.folders = folders;
    }

    public String getAllPath() {
        return allPath;
    }

    public void setAllPath(String allPath) {
        this.allPath = allPath;
    }

    public String getPath() {
//        String[] a = this.getAllPath().split("\\\\");
        int i = this.getAllPath().lastIndexOf("\\");      
        return this.getAllPath().substring(0, i);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        int i = this.getAllPath().lastIndexOf("\\");
        int k = this.getAllPath().lastIndexOf("."); 
        return this.getAllPath().substring(i+1, k);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        int i = this.getAllPath().lastIndexOf(".");      
        return  this.getAllPath().substring(i+1);
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDisk() {
        int i = this.getAllPath().lastIndexOf(":");  
        return this.getAllPath().substring(0, i+1);
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getFolders() {
        int i = this.getAllPath().lastIndexOf("\\");
        int l = this.getAllPath().substring(0, i).lastIndexOf("\\");
        int k = this.getAllPath().lastIndexOf("\\"); 
        return this.getAllPath().substring(l+1, k);
    }

    public void setFolders(String folders) {
        this.folders = folders;
    }

    @Override
    public String toString() {
        return "Disk: " + this.getDisk() + "\nExtension: " + this.getExtension() + "\nFile Name: " + this.getFileName()+ "\nPath: " + this.getPath() + "\nFolders: [" + this.getFolders()+"]";
    }
    
}

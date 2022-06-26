package utils.file;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 *  打.tar.gz包的工具类
 */
public class TarGipFileUtil {

    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\aa\\Desktop\\da\\dsa";
        String tarFilePath = "C:\\Users\\aa\\Desktop\\da";
        String tarFileName = "ide-sdk.tar.gz";
        createTarFile(sourceFilePath, tarFilePath, "", tarFileName);
    }
    /**
     * 把一个目录下的所有文件和文件夹打成.tar.gz包（从当前的目录开始）
     * <p>Method ：createTarFile
     * <p>Description : 打包文件 .tar.gz
     *
     * @param sourceFolder 需要打成.tar.gz包的目录（包含目录和目录下的所有文件和文件夹）例：E:/aarm/test
     * @param tarGzPath  打成的tar包生成的目标目录 例： D:/tmp  最终打包会在 D:/tmp目录下生成 test.tar.gz包
     * @param ignoreDir 需要忽略的目录
     * @param tarGzFileName 打tar.gz包的名，例如：ide-sdk.tar.gz
     */
    public static void createTarFile(String sourceFolder, String tarGzPath,String ignoreDir, String tarGzFileName) {
        TarArchiveOutputStream tarOs = null;
        try {
            File tarGzFile = new File(tarGzPath);
            File sourceFile = new File(sourceFolder);
            if (!tarGzFile.exists()) {
                tarGzFile.mkdirs();
            }
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("压缩的目录不存在。。。");
            }
            // 创建一个 FileOutputStream 到输出文件（.tar.gz）
            File tarFile = new File(tarGzFile + "/" + tarGzFileName);
            FileOutputStream fos = new FileOutputStream(tarFile);
//			// 创建一个 GZIPOutputStream，用来包装 FileOutputStream 对象
            GZIPOutputStream gos = new GZIPOutputStream(new BufferedOutputStream(fos));
            // 创建一个 TarArchiveOutputStream，用来包装 GZIPOutputStream 对象
            tarOs = new TarArchiveOutputStream(gos);
            // 若不设置此模式，当文件名超过 100 个字节时会抛出异常，异常大致如下：
            // is too long ( > 100 bytes)
            // 具体可参考官方文档：http://commons.apache.org/proper/commons-compress/tar.html#Long_File_Names
            tarOs.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
            addFilesToTarGZ(sourceFile, "", tarOs,ignoreDir);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                tarOs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 把文件复制到.tar.gz包中
     * @param file 需要复制的文件
     * @param parent 父目录
     * @param tarArchive tar包流
     * @param ignoreDir 忽略的目录
     * @throws IOException 异常
     */
    public static void addFilesToTarGZ(File file, String parent, TarArchiveOutputStream tarArchive,String ignoreDir)
            throws IOException {
        //不要再包一层最上面的目录
        if(parent.startsWith(ignoreDir+ File.separator)) {
            parent = parent.replace(ignoreDir+File.separator, File.separator);
        }
        String entryName = parent + file.getName();
        if(!parent.equals("")) {
            // 添加 tar ArchiveEntry
            tarArchive.putArchiveEntry(new TarArchiveEntry(file, entryName));
        }
        if (file.isFile()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            // 写入文件
            IOUtils.copy(bis, tarArchive);
            tarArchive.closeArchiveEntry();
            bis.close();
        } else if (file.isDirectory()) {
            // 因为是个文件夹，无需写入内容，关闭即可
            if(!parent.equals("")) {
                tarArchive.closeArchiveEntry();
            }
            File[] files = file.listFiles();
            if (files != null) {
                // 读取文件夹下所有文件
                for (File f : files) {
                    // 递归
                    addFilesToTarGZ(new File(f.getAbsolutePath()), entryName + File.separator, tarArchive,ignoreDir);
                }
            }
        }
    }


    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
    /**
     *
     * <p>Method ：copyDirectory
     * <p>Description :  复制文件夹
     *
     * @param sourcePathString
     * @param targetPathString
     */
    public static void copyDirectory(String sourcePathString,String targetPathString){
        if(!new File(sourcePathString).canRead()){
            System.out.println("源文件夹" + sourcePathString + "不可读，无法复制！");
        }else{
            (new File(targetPathString)).mkdirs();
            System.out.println("开始复制文件夹" + sourcePathString + "到" + targetPathString);
            File[] files = new File(sourcePathString).listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    copyFile(new File(sourcePathString + File.separator + file.getName()), new File(targetPathString + File.separator + file.getName()));
                } else if (file.isDirectory()) {
                    copyDirectory(sourcePathString + File.separator + file.getName(), targetPathString + File.separator + file.getName());
                }
            }
            System.out.println("复制文件夹" + sourcePathString + "到" + targetPathString + "结束");
        }
    }
    /**
     *
     * <p>Method ：copyFile
     * <p>Description : 复制文件
     *
     * @param sourceFile
     * @param targetFile
     */
    public static void copyFile(File sourceFile,File targetFile){
        if(!sourceFile.canRead()){
            System.out.println("源文件" + sourceFile.getAbsolutePath() + "不可读，无法复制！");
        }else{
            System.out.println("开始复制文件" + sourceFile.getAbsolutePath() + "到" + targetFile.getAbsolutePath());
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            FileOutputStream fos = null;
            BufferedOutputStream bos = null;
            try{
                fis = new FileInputStream(sourceFile);
                bis = new BufferedInputStream(fis);
                fos = new FileOutputStream(targetFile);
                bos = new BufferedOutputStream(fos);
                int len = 0;
                while((len = bis.read()) != -1){
                    bos.write(len);
                }
                bos.flush();

            } catch(IOException e){
                e.printStackTrace();
            } finally{
                try{
                    if(fis != null){
                        fis.close();
                    }
                    if(bis != null){
                        bis.close();
                    }
                    if(fos != null){
                        fos.close();
                    }
                    if(bos != null){
                        bos.close();
                    }
                    System.out.println("文件" + sourceFile.getAbsolutePath() + "复制到" + targetFile.getAbsolutePath() + "完成");
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}



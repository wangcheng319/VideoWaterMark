package com.czh.testmpeg.videocompress;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	private static final String TAG = "tyhj";
	private static final File parentPath = Environment.getExternalStorageDirectory();
	private static String storagePath = "";
	private static final String DST_FOLDER_NAME = "tyhj3";

	/**初始化保存路径
	 * @return
	 */
	public static String initPath(){
		if(storagePath.equals("")){
			storagePath = parentPath.getAbsolutePath() ;
			File f = new File(storagePath);
			if(!f.exists()){
				f.mkdir();
			}
		}
		return storagePath;
	}

	/**保存Bitmap到sdcard
	 * @param b
	 */
	public static void saveBitmap(Bitmap b){

		String path = initPath();
		long dataTake = System.currentTimeMillis();
		String jpegName = path + "/" + "moreinfo" +".jpg";
		Log.i(TAG, "saveBitmap:jpegName = " + jpegName);
		try {
			FileOutputStream fout = new FileOutputStream(jpegName);
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			b.compress(Bitmap.CompressFormat.JPEG, 80, bos);
			bos.flush();
			bos.close();
			Log.e("===", "saveBitmap成功");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e("===", "saveBitmap:失败");
			e.printStackTrace();
		}

	}


}

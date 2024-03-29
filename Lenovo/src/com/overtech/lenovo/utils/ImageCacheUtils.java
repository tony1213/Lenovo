package com.overtech.lenovo.utils;
import java.io.InputStream;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.provider.MediaStore;
  
/** 
 * @author will. 
 * 工具类. 
 */  
public class ImageCacheUtils {  
  
    /** 
     * 获取合适的Bitmap平时获取Bitmap就用这个方法吧. 
     * @param path 路径. 
     * @param data byte[]数组. 
     * @param context 上下文 
     * @param uri uri 
     * @param target 模板宽或者高的大小. 
     * @param width 是否是宽度 
     * @return 
     */  
    public static Bitmap getResizedBitmap(String path, byte[] data,  
            Context context,Uri uri, int target, boolean width) {  
        Options options = null;  
  
        if (target > 0) {  
  
            Options info = new Options();  
            //这里设置true的时候，decode时候Bitmap返回的为空，  
            //将图片宽高读取放在Options里.  
            info.inJustDecodeBounds = false;  
              
            decode(path, data, context,uri, info);  
              
            int dim = info.outWidth;  
            if (!width)  
                dim = Math.max(dim, info.outHeight);  
            int ssize = sampleSize(dim, target);  
  
            options = new Options();  
            options.inSampleSize = ssize;  
  
        }  
  
        Bitmap bm = null;  
        try {  
            bm = decode(path, data, context,uri, options);  
        } catch(Exception e){  
            e.printStackTrace();  
        }  
        return bm;  
  
    }  
      
    /** 
     * 解析Bitmap的公用方法. 
     * @param path 
     * @param data 
     * @param context 
     * @param uri 
     * @param options 
     * @return 
     */  
    public static Bitmap decode(String path, byte[] data, Context context,  
            Uri uri, BitmapFactory.Options options) {  
  
        Bitmap result = null;  
  
        if (path != null) {  
  
            result = BitmapFactory.decodeFile(path, options);  
  
        } else if (data != null) {  
  
            result = BitmapFactory.decodeByteArray(data, 0, data.length,  
                    options);  
  
        } else if (uri != null) {  
            //uri不为空的时候context也不要为空.  
            ContentResolver cr = context.getContentResolver();  
            InputStream inputStream = null;  
  
            try {  
                inputStream = cr.openInputStream(uri);  
                result = BitmapFactory.decodeStream(inputStream, null, options);  
                inputStream.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
  
        }  
  
        return result;  
    }  
    /**
     * 该方法在这里可能不合适，
     * @param context
     * @param photoName
     * @return
     */
    public static Bitmap getBitmap(Context context,String photoName){
    	BitmapFactory.Options op = new BitmapFactory.Options();
		// 设置图片的大小
		Bitmap bitMap = BitmapFactory.decodeFile(photoName);
		//插入系统相册
		MediaStore.Images.Media.insertImage(context.getContentResolver(), bitMap, "", "");  
		
		int width = bitMap.getWidth();
		int height = bitMap.getHeight();
		// 设置想要的大小
		int newWidth = 480;
		int newHeight = 640;
		// 计算缩放比例
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 取得想要缩放的matrix参数
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		// 得到新的图片
		bitMap = Bitmap.createBitmap(bitMap, 0, 0, width, height,
				matrix, true);
		// canvas.drawBitmap(bitMap, 0, 0, paint)
		// 防止内存溢出
		op.inSampleSize = 4; // 这个数字越大,图片大小越小.
		Bitmap pic = null;
		pic = BitmapFactory.decodeFile(photoName, op);
    	return pic;
    }
    /**
     * 圆角图片的实现
     * @param source
     * @return
     */
    public static Bitmap toRoundBitmap(Bitmap source){
    	int STROKE_WIDTH = 4;
		int width = source.getWidth();
		int height = source.getHeight();
		float roundPx;
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		if (width <= height) {
			roundPx = width / 2;
			top = 0;
			left = 0;
			bottom = width;
			right = width;
			height = width;
			dst_left = 0;
			dst_top = 0;
			dst_right = width;
			dst_bottom = width;
		} else {
			roundPx = height / 2;
			float clip = (width - height) / 2;
			left = clip;
			right = width - clip;
			top = 0;
			bottom = height;
			width = height;
			dst_left = 0;
			dst_top = 0;
			dst_right = height;
			dst_bottom = height;
		}

		Bitmap output = Bitmap.createBitmap(width,
				height, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect src = new Rect((int) left,
				(int) top, (int) right,
				(int) bottom);
		final Rect dst = new Rect((int) dst_left,
				(int) dst_top, (int) dst_right,
				(int) dst_bottom);
		final RectF rectF = new RectF(dst);

		paint.setAntiAlias(true);

		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(Color.WHITE);
		paint.setStrokeWidth(4);
		canvas.drawRoundRect(rectF, roundPx,
				roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(
				Mode.SRC_IN));
		canvas.drawBitmap(source, src, dst, paint);

		if(!source.isRecycled()){
			source.recycle();//回收被处理的图片，否则会报异常
		}
		// 画白色圆圈
		paint.reset();
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(STROKE_WIDTH);
		paint.setAntiAlias(true);
		canvas.drawCircle(width / 2, width / 2,
				width / 2 - STROKE_WIDTH / 2, paint);
		return output;
    }
    /** 
     * 获取合适的sampleSize. 
     * 这里就简单实现都是2的倍数啦. 
     * @param width 
     * @param target 
     * @return 
     */  
    private static int sampleSize(int width, int target){             
            int result = 1;           
            for(int i = 0; i < 10; i++){               
                if(width < target * 2){  
                    break;  
                }                 
                width = width / 2;  
                result = result * 2;                  
            }             
            return result;  
        }  
}  
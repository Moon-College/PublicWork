package com.fyf.nodie.people;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class Role {
	private Bitmap bitmap;//当前图片
	private Bitmap[] bms;//完成一个动作的图片数组
	float x,y;
	float speedX,speedY;
	int width,heigth;
	private long lastTime;
	private int index;
	
	public Role(Bitmap[] bms,float x,float y){
		this.bms = bms;
		this.bitmap = bms[0];
		this.width = bitmap.getWidth();
		this.heigth = bitmap.getHeight();
		this.x = x;
		this.y = y;
	}
	/**
	 * 动画
	 * @param span
	 */
	private void animateRole(long span){
		Long nowTimeLong = System.currentTimeMillis();
		if((nowTimeLong-lastTime) >=span){
			//切换图片
			index ++;
			if(index ==bms.length){
				index = 0;
			}
			bitmap = bms[index];
			lastTime = System.currentTimeMillis();		
		}
	}
	/**
	 * 绘制自己
	 * @param canvas
	 */
	public void drawSelf(Canvas canvas){
		animateRole(200);
		canvas.drawBitmap(bitmap, this.getX(),this.getY(),null);
	}
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	
	public Bitmap[] getBms() {
		return bms;
	}
	public void setBms(Bitmap[] bmsBitmaps) {
		this.bms = bmsBitmaps;
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	
	public float getSpeedX() {
		return speedX;
	}
	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
}

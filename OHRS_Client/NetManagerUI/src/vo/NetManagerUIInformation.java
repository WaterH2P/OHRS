package vo;

import java.lang.reflect.Field;

public abstract class NetManagerUIInformation {
	public void setByReflection(String fieldName,String value){
				Field field=null;
				try {
					field = getClass().getField(fieldName);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					field.set(this, value);
				} catch (Exception e){
					try {
						field.set(this,Integer.parseInt(value));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
		
	}
	public abstract String[] getChineseFieldName();
}

package com.depositsolutions.pages;

import java.io.IOException;
import com.depositsolutions.utils.Constants;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Page object class for REST APIs for getting and deleting users
 */
public class ServicePageObject {

	/**
	 *  Method to get all the created users using OkHttpClient
	 *  @param GET HTTP method
     *  @return ResponseBody  
     */
	public static ResponseBody getUsers() throws IOException, InterruptedException{
		/**
		 *  Initialize OkHttpClient
	     */
		OkHttpClient client = new OkHttpClient();

		/**
		 *  Create Request builder 
	     */
		Request request = new Request.Builder()
		  .url(Constants.GET_USERS)
		  .get()
		  .build();

		/**
		 *  Execute request and assign the response to Response reference variable
	     */
		Response response = client.newCall(request).execute();
		return response.body();
	}
	
	/**
	 *  Method to delete all the created users using OkHttpClient
	 *  @param DELETE HTTP method
     *  @return ResponseBody  
     */
	public static String deleteUsers() throws IOException{
		
		/**
		 *  Initialize OkHttpClient
	     */
		OkHttpClient client = new OkHttpClient();

		/**
		 *  Create Request builder 
	     */
		Request request = new Request.Builder()
		  .url(Constants.DELETE_USERS)
		  .delete()
		  .build();

		/**
		 *  Execute request and assign the response to Response reference variable
	     */
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}

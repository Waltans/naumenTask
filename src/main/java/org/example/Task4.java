package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class Task4 {
	public static void main(String[] args) {
		String urlString = "https://httpbin.org/get";
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String inputLine;
				
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				
				JSONObject jsonResponse = new JSONObject(response.toString());
				String host = jsonResponse.getJSONObject("headers")
					.getString("Host");
				
				System.out.println(host);
			} else {
				System.out.println("Ошибка в запросе: " + responseCode);
			}
		} catch (Exception e) {
			System.out.println("Oops...");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

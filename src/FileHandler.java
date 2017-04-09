import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import data.AirportData;
import data.RouteData;



public class FileHandler {

	public ArrayList<RouteData> loadRoutesFromFile(String filename){
		ArrayList<RouteData> routeData = new ArrayList<>();
		String NewLine;

		FileReader TheFileReader;
		BufferedReader TheBufferedReader;

		try {
			TheFileReader = new FileReader(new File(filename));
			TheBufferedReader = new BufferedReader(TheFileReader);
			TheBufferedReader.readLine();
			while((NewLine = TheBufferedReader.readLine()) != null){
				String[] cleanLine = NewLine.split(";");
				if(cleanLine.length==5){
					RouteData r = new RouteData(cleanLine[0], cleanLine[1], cleanLine[2], Float.valueOf(cleanLine[3]), Float.valueOf(cleanLine[4]));
					routeData.add(r);
				}
			}

			TheBufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return routeData;
	}

	public ArrayList<AirportData> loadAirportsFromFile(String filename)
	{
		ArrayList<AirportData> airportData = new ArrayList<>();
		String NewLine;

		FileReader TheFileReader;
		BufferedReader TheBufferedReader;

		try {
			TheFileReader = new FileReader(new File(filename));
			TheBufferedReader = new BufferedReader(TheFileReader);
			TheBufferedReader.readLine();
			while((NewLine = TheBufferedReader.readLine()) != null){
				String[] cleanLine = NewLine.split(";");
				if(cleanLine.length==6){
					AirportData airport_data = new AirportData(cleanLine[0], cleanLine[1], cleanLine[2], cleanLine[3], Float.valueOf(cleanLine[4]), Float.valueOf(cleanLine[5]));
					airportData.add(airport_data);
				}
			}

			TheBufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return airportData;
	}

	public void saveTextToFile(ArrayList<String> wordList, String filename)
	{       
		try
		{
			FileWriter TheFileWriter = new FileWriter(new File(filename));

			for(int i = 0; i < wordList.size(); i++)
			{
				TheFileWriter.write(wordList.get(i) + " ");
			}           

			TheFileWriter.close();  
		}
		catch (IOException ex)
		{
			System.out.println("Could not write to file!");
			System.out.println(ex.toString());
		}
	}

}

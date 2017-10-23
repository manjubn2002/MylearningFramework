package factory;

import dataprovider.ConfigDataProvider;

public class Dataproviderfactory 
{

	public static ConfigDataProvider getconfig()
	
	{
		ConfigDataProvider config=new ConfigDataProvider();
				return config;
		
	}
}

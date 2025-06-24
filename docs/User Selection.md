# User Selection

This doc covers my process accessing the Art Institute of Chicago API and returning artworks that align with the user's desired filters.

## Welcome Screen

In the Welcome Screen, whenever the user selects a filter by clicking on the corresponding checkbox, it is added to a TreeMap in the **UserSelection** class.

The UserSelection class is meant to collect all the filters a user wants in one data structure, which I chose to be a TreeMap. When a user clicks on one of the options, the **addFilter** method is run, which obviously adds the filter to the **filters** TreeMap. Logically, if the user deselects an option, the **removeFilter** method is run.

## Transition

Once the user clicks the "Proceed" Button, most of the code to access the API is run. This resulted in some additional complexities, explained further in the GUI Setup doc. The central node for everything data related is in the **DataHandler** class. 

This class has 2 private ArrayLists: **artworkList** and **rejectList**. **rejectList** will be explained further in another doc.

The first method in this class is **getJSONString**, which I think is the most important method in the entire program - after all, it accesses the API. A detailed description is below:

```
public String getJSONString(String apiEndpoint) {
        
      try { //surrounded code in try-catch block that safeguards in case of errors like internet issues
            
          HttpClient client = HttpClient.newHttpClient(); //creates an HTTP client, like a web browser to send/receive websites' data
          HttpRequest request = HttpRequest.newBuilder().GET() //just asking for data, not receiving any
                  .uri(new URI("https://api.artic.edu/api/v1/" + apiEndpoint)).build(); //pieces together the full website link using inputted "API Endpoint" string
          HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); //sends request to website and waits for response
            
          return response.body(); //returns the JSON data
            
      } catch (URISyntaxException | InterruptedException | IOException ex) {
          System.out.println(ex.toString()); //catches and prints out any errors that might occur
      }
        
      return null;
}
``` 

The next method, **getArtworkData**, basically calls the previous method. This wasn't absolutely necessary, but I just wanted some cleaner code and having a method solely for retrieving data helped with that. 

Also, since I was now working with JSON data, I needed a way to understand JSON format so that I could use tools like JSONObject and JSONArray. This ended up being a **JSON library**. To do this, I installed a dependency in the **pom.xml** file, which is like my project's shopping list for libraries. This was the code for installation:

```
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20250107</version>
</dependency>
```





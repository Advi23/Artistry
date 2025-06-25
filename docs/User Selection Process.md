# User Selection Process

This doc covers my process accessing the Art Institute of Chicago API and returning artworks that align with the user's desired filters.

## User Selection

In the Welcome Screen, whenever the user selects a filter by clicking on the corresponding checkbox, it is added to a TreeMap in the **UserSelection** class.

The UserSelection class is meant to collect all the filters a user wants in one data structure, which I chose to be a TreeMap. When a user clicks on one of the options, the **addFilter** method is run, which obviously adds the filter to the **filters** TreeMap. Logically, if the user deselects an option, the **removeFilter** method is run.

## Data Handler

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

Now it was time to finally retrieve the artwork, storing in a method named **fetchArtwork**. This took in a String argument called **filter** and returned an ArrayList<String>. I first created an endpoint of "artworks/search?q=" + **filter**, using that 
String to run **getArtworkData(endpoint)**. What this does is collect all the JSON data you get for the following search query (this is if the filter was "architecture"): [https://api.artic.edu/api/v1/artworks/search?q=architecture](https://api.artic.edu/api/v1/artworks/search?q=architecture). 

The above query is searching for all artworks in the Art Institute of Chicago's database that are filed under the keyword "architecture". Because of my method of filtering, this is why I couldn't add dates or time periods as filters for the Welcome Screen. I stored the JSON data in the variable **allFilteredArtworks**. 

However, there were more complications. Even with a filter, any query still resulted in hundreds of artworks, which is a huge amount of processing for my application. Luckily, the JSON data is helpfully organized into pages, each of which have 10 artworks. By randomly selecting a page of artworks (using a random number method), the program could still provide diverse pieces of work. The final page worth of JSON data was stored in the variable **finalFilteredArtworks**. 

I further organized the collected data into a JSONArray, so that each item in the array is 1 artwork. By randomly selecting one artwork from that array, I finally had the piece that was going to be presented. The data for this artwork is stored in the variable **artworkData**.

Now it was time to extract the information I needed, including the **artwork ID** (a unique identifier the Art Institute of Chicago uses for every artwork), **title**, **display date**, **artist**, **place of origin**, **artwork image ID**, and a **short description** (if applicable). Before extracting, I created 2 boolean statements to check if the art piece had a title and accompanying image ID (for a picture). Without these 2 things, I couldn't add it to the final display as it would look out of place and not really educate anyone.

I used a while loop so that the entire artwork selection process would only end once an artwork that had both a title and image was selected. I thought of an (extremely unlikely) edge case where the program would _always_ return an artwork that didn't meet the criteria, so I made a limit of 10 attempts. In the case where a suitable artwork wasn't found after 10 attempts, **fetchArtwork** returned an empty ArrayList.

Now that the qualifying criteria was met, I stored the extracted information mentioned above into an ArrayList called **artworkDetails**. This was returned. 

## Artwork

However, I didn't want to use an ArrayList to store my artwork's information. It seemed too unorganized, and wouldn't help me down the road for my other purposes. Thus, the **Artwork** class was created. This is a fairly simple class that only creates a new object that holds all the extracted information as arguments.

Going back to the **DataHandler** class, the **generateArtwork** method converts the returned ArrayList from the **fetchArtwork** method into a new **Artwork** object.

Finally, the **compileArtworks** method ties everything together, taking in the **UserSelection** object I referred to at the beginning and generating an ArrayList of 5 randomized artworks based on the user's specifications. This is done by looping through the **values** of the UserSelection TreeMap and inputting each filter into the **fetchArtwork -> generateArtwork** pipeline before adding the final **Artwork** object into the **artworkList** ArrayList. 

However, since this whole process is dependent on the filters in the UserSelection object, what happens when a user chooses less than 5 filters? The program is still expected to return 5 artworks, so it randomly selects another filter from the **filters** TreeMap until 5 works are reached.

At this point, we are left with an ArrayList of the user's artworks, and the description of how this data is displayed in the Main Screen is in another doc.















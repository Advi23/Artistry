# Main and Individual Screens Setup

This doc covers the process of formatting the data retrieved from the Art Institute of Chicago API and displaying it in the _Artistry_ Main Screen. A lot of this doc refers back to methods in the **DataHandler** class, and a more detailed description of this class is available in the **User Selection Process** doc.

## Proceed Button

As soon as the "Proceed Button" is clicked, after some GUI changes a new **Data Handler** object is created and the **compileArtworks** method is run using the **userSelection** object that contains the user's selected filters as an argument. The ArrayList of Artworks created in the **compileArtworks** method is stored in the variable **artworks**. 

Next, each Artwork in the **artworks** ArrayList is looped through, and a new **ImageHandler** piece is created. 

## ImageHandler Class

The **ImageHandler** class was created to retrieve an image for each artwork. I could have added this code in the **DataHandler** class, but felt that would overcomplicate things. 

The **getIIIFImage** method retrieves the image based on a URL. The Art Institute of Chicago uses the IIIF Image API, and the URL retreival method was pretty similar. The 2 components that vary between each URL are the Artwork ID and dimensions. The IIIF website has a really [informative page](https://iiif.io/api/image/3.0/) that guided me through this process.

The **getArtworkImage** method just returns the image retrieved in the previous method.

## Generating Images

2 images are generated for each Artwork in the **artworks** class, one sized to fit in the **Main Screen** and one sized to fit in the **Individual Screen** when users maximize an artwork image. I got the dimensions for these images by using the JPanel dimensions where the image will be displayed.

The **MainScreen** BufferedImage is added to the **imagePanels** ArrayList, the **IndividualScreen** BufferedImage is added to the **individualPanels** ArrayList, and the title for each artwork is added to the **ImageLabels** ArrayList. The titles for these artworks can sometimes run really long, so for stylistic purposes I truncated them at 52 characters. After the for loop is completed, the **setup()** method is run.

## Setup Method

As the name suggests, this method provides a base for the Main Screen GUI. The artworks that will be displayed first are updated through the **ImagePanel** class. 

This class is custom made to display images on a JPanel. It features an **updateImage** class that takes in a BufferedImage as an argument and repaints the panel to show the new image. The labels underneath each image panel are accordingly updated as well. Finally, some work for the **Mini Quiz** feature is done as well, but this will be explained further in the appropriate doc.

## Carousel Method

The **photoCarousel** method deals with updating the images displayed whenever the user clicks the **Next** or **Back** buttons. I wanted a seamless, infinite circle which was one of the features I wanted most.

The code for this method is displayed below:

```
private void photoCarousel(JPanel panel1, JPanel panel2, JPanel panel3, 
            JLabel label1, JLabel label2, JLabel label3) {
        
        if (countClicks > imagePanels.size() - 1) {
            countClicks = 0;
        }
        if (countClicks < 0) {
            countClicks = imagePanels.size() - 1;
        }
        
        int beforeCount = countClicks - 1;
        if (beforeCount < 0) {
            beforeCount = imagePanels.size() - 1;
        }
        
        int afterCount = countClicks + 1;
        if (afterCount >= imagePanels.size()) {
            afterCount = 0;
        }
        
        ((ImagePanel)panel1).updateImage(imagePanels.get(beforeCount));
        ((ImagePanel)panel2).updateImage(imagePanels.get(countClicks));
        ((ImagePanel)panel3).updateImage(imagePanels.get(afterCount));
        
        label1.setText(imageLabels.get(beforeCount));
        label2.setText(imageLabels.get(countClicks));
        label3.setText(imageLabels.get(afterCount));  
    }
```
The panels and labels taken in as arguments are the objects displayed on the screen.

## Individual Screen

When the user clicks on the **Maximize** button on the top-left corner of each work in **Main Screen**, the **changePanel** method (explained in the GUI Setup doc) is run, and the panel is switched to the **Individual Screen** panel. From here, all the details are updated using the following method:

```
private void setIndividualScreen(int index) {
        
        BufferedImage currentImage = individualPanels.get(index);
        ((ImagePanel)panel_individualImage).updateImage(currentImage);
        
        Artwork individualPiece = artworks.get(index);
        label_Title.setText(individualPiece.getTitle());
        label_Date.setText("Created: " + individualPiece.getDate_created());
        label_Artist.setText("Created By: " + individualPiece.getArtist());
        label_Place.setText("Made In: " + individualPiece.getPlace_created());
        
        String description = individualPiece.getShort_description();
        textPane_description.setText(description);
        textPane_description.setContentType("text/html");
        textPane_description.setText(
        "<html>" +
            "<div style='text-align: center;'>" +
            description +
            "</div>" +
        "</html>");
    }
```










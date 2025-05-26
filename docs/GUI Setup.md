# GUI Setup

This doc covers my process creating the GUI for _Artistry_.

## Overview / Initial Build

As I was a beginner developer while making this project, I chose to create my GUI entirely using Netbeans' interface. For my next Java project, I would likely use code, as that option allows for a lot more customizability. It's also easier to fix your mistakes. 

I started building my GUI a bit overzealously, and this lack of a plan created lots of problems later on. 

I began by creating a JFrame Form titled 'MainWindow'. This would be the base of my GUI. 

I would say the most important component in a Netbeans GUI is what layout you make your panels in. At the beginning, I didn't even know that there _were_ different layouts, so I just used the standard one: **Free Design**.

I began piecing together the welcome screen for my app, but issues arose when I needed to transition between screens. Once the user is done selecting their desired options, they're supposed to move to a Main Screen that features results, right? Well, with the **Free Design** layout, that can't be easily achieved. 

Originally I just used **Tabbed Panes** to switch between screens, but I really wanted the design of my app to closely resemble my prototype [made in Canva](https://www.canva.com/design/DAGoFS6iFCU/ZHmJgC1sDlgl4gLJ4rQVpA/view?utm_content=DAGoFS6iFCU&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=he3244e21ac) and smoothly transition with the click of a button, so I looked to the internet for solutions.

This was where I realized **Free Design** was not going to work as I couldn't switch between panels easily within a single JFrame. I ended up having to scrap my first GUI and start an entirely new project, which is why it's called **artistry2** :'). 

The second time, I planned everything out on paper, and I knew the first step would be to figure out what layout I needed. 

A **Card Layout** looked to offer all the functionalities I needed, and this [Youtube tutorial](https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.youtube.com/watch%3Fv%3DL-UPOw1nHCI&ved=2ahUKEwiWsaKL1rKNAxVSL9AFHWNIIQcQwqsBegQIDRAG&usg=AOvVaw2q6cIksdhkMfMWpQO0JV1f) was extremely helpful in learning the setup process and basic techniques.

With this layout, you need to have a base panel that serves as your starting point. From there, you can nest all the different panels that you want to switch between. My setup looked like:

<p align = "center">
<img src="/../master/images/CardLayout.png" width="400">
</p>

## Welcome Screen Setup

Now that I had my basic layout, I needed to get started with my **panel_welcome**, or the Welcome Screen. I first created a label on top that gave simple instructions for _Artistry_. I customized it by right-clicking on the label and selecting **Properties**. From there, I could change the background color, font, and horizontal/vertical alignment. 

For the images, I chose to create them on a new panel called **panel_options**, because I wanted to experiment with different layout styles and didn't want to have to start over _again_ if I messed up. 

I first tried out the **Grid Layout** for panel_options, and [this Youtube tutorial](https://www.youtube.com/watch?v=impJtkTcQ94) was helpful in starting out. However, I soon realized that this layout wouldn't work well since I needed to also place checkboxes close to the corresponding image, and that wasn't easily allowed. 

Further research pointed me to the **Absolute Layout**, which is very flexible in that you can place things basically anywhere you'd like. A prototype seemed to work fine, and I proceeded to customize the layout. 

After the layout, the biggest challenge with this section was adding my custom images to show the various filters available. My first resource was the official Netbeans website, but once I followed its instructions I began getting a 'null: location not found' error. Off to the web I went.

I ended up having to mash up a lot of different tutorials to get a working result, so here's my method:

1. In the **Files** tab (should be next to projects), create a new folder in your **main** folder. This is specifically for your images. I named mine 'resources'.
2. Copy and paste your desired files into this 'resources' folder.
3. Right-click on your label, select properties, and go to the **icon** property.
4. Click the 3 dots and choose the 'Image Within Project' option.
5. You should be set to the 'default' package, and from there select your desired image file from the dropdown

[This YouTube tutorial](https://www.youtube.com/watch?v=fwiBilSLnS0) provided the most guidance. Unfortunately, Netbeans doesn't allow image resizing in the editor itself, so the image inside the 'resources' folder needs to be your desired dimensions. This was a sort of guess-and-check process for me, especially since I have no sense of perspective, and [this image resizer](https://www.simpleimageresizer.com) ended up working the best.

Here are some screenshots detailing the process more clearly:

<p align = "center">
<img src="/../master/images/ResourcesFolder.png" width="300"> 
<img src="/../master/images/IconProperty.png" width="450">
</p>

Next, I wanted to track the number of options a user selects, making sure to count for deselections and edge cases (too many, none, etc.)
To do this, I used a class variable called **checkBoxesFilled** that keeps track of all checkboxes selected using the JCheckBox method **.isSelected()** (this was a lifesaver!). The **maxBoxes()** method basically changes the label that counts the number of checkboxes selected, changing its text based on if a maximum amount of filters were picked. 

The **chooseFilter()** method (explained in more detail later) also contains some code that changes the value of **checkBoxesFilled** based on a selection or deselection.

## Transitions

Once everything in **panel_welcome** was set to my liking, I now needed to move to **panel_mainScreen** at the click of a button. Luckily, my CardLayout YT video already explained the process, and I created a public method since I wanted to reuse the commands when moving between all screens. Here's my **changePanel()** method:

```
private void changePanel(JPanel panelBase, JPanel panelAdd) {
        
        panelBase.removeAll();
        panelBase.add(panelAdd);
        panelBase.repaint();
        panelBase.revalidate();

}
```
The **panelBase** is the base panel I was referencing before, and basically what we're doing is removing all the panels from this foundation, adding your desired panel that you want to transition to, and repainting the base panel.

I also only allowed this method to be executed if **checkBoxesFilled** was greater than 0 (user picked at least 1 filter) and less than 5 (the max number of filters I allowed).

## Main Screen Setup

I next proceeded to setup my Main Screen. I started out by again adding my custom labels, buttons, and icons. The overview and general buttons were easy enough to set up. I wanted to add an instructions screen to help out users, so this involved creating a button and adding those 'i' icons, which took quite a bit of guesswork for the correct size.

To transition to the **panel_Instructions** where the tutorial was displayed, I used the **changePanel()** method mentioned previously. I also added a 'Proceed to Mini Quiz' button and 'Regenerate' button. I explain the logistics behind the **Regenerate button** in full detail in another doc. 

I also needed to actually display images based on the user's selection, so this involved an extensive interlude of accessing the API and then using that retrieved data, which again I explain in another doc. This doc is also where I dive into my custom "carousel" method of displaying images in a revolving manner seamlessly. 

For each image, I added 2 options: maximizing the image to see more details, and removing the image and replacing it with a new one. Both of these icons were again imported in a similar manner to my Welcome Screen pictures. These individual images will be explained in further detail in the **Individual Screen Setup** portion.

Without detailing all of the background work, I guess all I did for this portion of the GUI was add labels and buttons :).

## Instructions Setup

This section of the GUI is pretty self explanatory: I literally just added instructions for _Artistry_, but I still included it because I learned some things about Swing Controls.

After adding the basic overview description and 'return to Main Screen' button, it was time for the actual tutorial.

My first idea was to use a label for the text like I'd been doing for all the other text features, but I incorrectly assumed the label would automatically switch to multi-line text once it reached the maximum width. However, the text just trails off into ellipses (this actually ended up being beneficial later on!). 

After a frightening encounter with Text Panes, I finally landed on the **Text Area**, whose description is 'A multi-line area that displays plain text'. Huh, that's exactly what I needed!

The only annoying part was having to format and center everything myself, which was especially inconvenient whenever I found a typo or wanted to reexplain a feature :,).

Once I beautified everything with a pop of color and font, this panel was ready to go.

























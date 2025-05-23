# GUI Setup

This file covers my process creating the GUI for _Artistry_.

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
5. You should be set to the <default> package, and from there select your desired image file from the dropdown

[This YouTube tutorial](https://www.youtube.com/watch?v=fwiBilSLnS0) provided the most guidance. Unfortunately, Netbeans doesn't allow image resizing in the editor itself, so the image inside the 'resources' folder needs to be your desired dimensions. This was a sort of guess-and-check process for me, especially since I have no sense of perspective, and [this image resizer](https://www.simpleimageresizer.com) ended up working the best.

Here are some screenshots detailing the process more clearly:

<p align = "center">
<img src="/../master/images/CardLayout.png" width="300"> 
<img src="/../master/images/CardLayout.png" width="300">
</p>











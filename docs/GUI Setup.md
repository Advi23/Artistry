# GUI Setup

This file covers my process setting up the GUI for _Artistry_.

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

![Screenshot of Netbeans CardLayout](/../master/images/CardLayout.png)





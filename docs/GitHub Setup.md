# GitHub Setup

This doc is covers my process transferring my work from Apache Netbeans to GitHub

My first step was going to the internet, since I had 0 previous experience with transferring files to GitHub.
I already had an account, but that was mostly for exploring and some small projects I made over the summer.

I found [this Medium article](https://mauricemuteti2015.medium.com/how-to-upload-push-add-netbeans-java-project-to-github-d3c098922663) to be helpful, at least with the initial steps.

I first completed steps 1-8 with some snafus expected while using a Mac. Something weird I found was that I couldn't create a custom path for my Git repository, which is apparently only a problem when initializing through Netbeans (terminal works too).

I ran into a big issue when entering my username and password. Whenever I submitted the information, I got a 'git-receive-pack' not permitted error. After some surfing on the web, it turned out that I needed to generate a [personal access token](https://github.com/githubschool/foundations-4-28-15/issues/11) due to increased security settings that occurred after the Medium article was published. Thanks, githubschool!

However, for some reason I started getting a new message (403 error) after creating my [fine grained PAT](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens) and finally gave up, choosing to use SSH to authenticate instead. I was also just using my terminal at this point because Netbeans was not cooperating.

(This GitHub doc)[https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent] helped with that process, and along the way I also needed to relearn some of my 'terminal-navigation' phrases.

After about an hour (an embarassingly long time ;_;), I finally had transferred all my files to my new GitHub repo!! I just quickly added a license to my master branch (my preferred default instead of main), and (set up my readmes)[https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax]. 

The most satisfying part was closing all the docs, stackoverflow, and google queries I had open.












# GitHub Setup

This doc covers my process transferring my work from Apache Netbeans to GitHub

My first step was going to the internet, since I had 0 previous experience with transferring files to GitHub.
I already had an account, but that was mostly for exploring and some small projects I made over the summer.

I found [this Medium article](https://mauricemuteti2015.medium.com/how-to-upload-push-add-netbeans-java-project-to-github-d3c098922663) to be helpful, at least with the initial steps.

I first completed steps 1-8 with some snafus expected while using a Mac. Something weird I found was that I couldn't create a custom path for my Git repository, which is apparently only a problem when initializing through Netbeans (terminal works too).

I ran into a big issue when entering my username and password. Whenever I submitted the information, I got a 'git-receive-pack' not permitted error. After some surfing on the web, it turned out that I needed to generate a [personal access token](https://github.com/githubschool/foundations-4-28-15/issues/11) due to increased security settings that occurred after the Medium article was published. Thanks, githubschool!

However, for some reason I started getting a new message (403 error) after creating my [fine grained PAT](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens) and finally gave up, choosing to use SSH to authenticate instead. I was also just using my terminal at this point because Netbeans was not cooperating.

[This GitHub doc](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent) helped with that process, and along the way I also needed to relearn some of my 'terminal-navigation' phrases:

```
ssh-keygen -t ed25519 -C "my_email"
** pressed enter for everything (not recommended as I skipped the passphrase, but I was at my limit at this point) **
cat ~/.ssh/id_ed25519.pub
```

After about an hour (an embarassingly long time ;_;), I finally transferred all my files to my new GitHub repo!! I just quickly added a license to my master branch (my preferred default instead of main), and [set up my readmes](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax). 

Something I think isn't covered much in the above docs, however, is inserting pictures. I think the best method is using relative links, where you pull and image from an existing folder in your repository (the 'images' folder for me), but I had quite a bit of trouble with alignments and resizing it. I pieced together this code after lots of Stack Overflow visits:

```
<p align="desired alignment">
  <img src="relative path to image" width="desired width (height automatically adjusts w/ aspect ratio" />
</p>

```

When I needed to commit new code after debugging or adding new features, I used these commands in my terminal after committing locally in Netbeans:

```
git pull origin master --rebase
git push origin master
```
The first command fetches the latest version of my code from GitHub and reapplies my latest changes on top. This is a safer and cleaner approach than using merge. The send command pushes the changes.








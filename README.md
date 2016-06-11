# Simplified Android MVP

What is MVP?

The MVP pattern allows separate the presentation layer from the logic, so that everything about
how the interface works is separated from how we represent it on screen. Ideally the MVP pattern
would achieve that same logic might have completely different and interchangeable views.
First thing to clarify is that MVP is not an architectural pattern, it’s only responsible for the
presentation layer . In any case it is always better to use it for your architecture that not using it at
all.

*Model*: This is the well known model, present in many of the most common patterns and use cases.
It represents the world we are working with, every real world element that our app should know
how to represent. Both the View and the Presenter are aware of this model and they know how to
use its properties and methods (the view doesn’t really need to know the model and originally
shouldn’t but it’s a tradeoff that avoids the need to have setter methods for every field that we want
to update).

*View*: As stated before, views are our Fragment and Activity classes that we are using, they are able
to alter the UI as we need and they need to receive structured data from a source in order to
populate themselves. This layer shouldn’t know anything else about the obtention of the data, we
made it as simple as we could.

*Presenter*: This layer, introduced here, is implemented with native java code meaning it doesn’t
need to know whether it’s used in an Android application or a web service. How does this work
with our structure previously described? Easy, what we are going to add to each view is a simple
interface which defines the actions that any view using a specific presenter would need to do in
order to populate itself with the data it provides. The presenter is responsible to act as the middle
man between view and model. It retrieves data from the model and returns it formatted to the view.
But unlike the typical MVC, it also decides what happens when you interact with the view.

### References 
* https://medium.com/mobiwise-blog/android-basic-project-architecture-for-mvp-72f4b33252d0#.gebnmc1rq
* http://antonioleiva.com/mvp-android
* http://hannesdorfmann.com/mosby/mvp/








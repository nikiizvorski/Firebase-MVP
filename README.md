FireBaseMVPDagger2
==========

Sample MVP Project containing Unit Tests, FireBase implementation and DI with Dagger2 and Java 1.8. You can use lambdas and streams. Lambdas are used only on functional interfaces where you can perform Intermediate and Terminate Operations. Functional interfaces can have as many as needed methods as long they are static and default and only one of them is abstract. Default methods are the one that you can provide implementation without the need of providing implementatio for them. There are a lot functional interfaces included in the standart API. If you need to use some of them you may have to check for the support in android.

This is how a proper non-spagetti code should look like! It have a good architecture a slight defects here and there which can be fixed but i wanted to share my knowlege with the rest and see how they can manage to fix this if they can actually see the problems. This project contains a proper Dagger2 implementation and a good MVP architecture which can be easy maintained and tested.

In the project you have Firebase login and some data from the firebase app. It can be a good step for someone that is just getting in to these libraries and into the android world.

If you decide to use RxJava don't forget to unsubscribe and make sure to make a subscription since you will understand what will happen if you don't :) simply your observable will just push or request data while there is none.

There may be some problems on older emulators which doesn't support Google Play Services 10+ if you have them simply test on a real device or wait for the update from google!

Project Structure? Updated for the latest 2.8 libs

- Component and Module -> Dagger2 -> DI
- Presenter -> Presentation Layer
- Activity -> View Layer
- Iterator and Model classes -> Model Layer

Using Parcelable? - these are just a couple ways to pass data between your activities

- Yes we are using Parcelable since it is specificly made for Android rather than the slow Serilizalable. If you want to read more on the topic you can go and find what marshaling and unmarshaling means in Java.

Removed transitions?

- Yes there is no need for any animations that's why we remove them completely.


#### Author

- Niki Izvorski (nikiizvorski@gmail.com)

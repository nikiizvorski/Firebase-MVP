FireBaseMVPDagger2
==========

Sample MVP Project containing Unit Tests, FireBase implementation and DI with Dagger2 and Java 1.8. You can use lambdas and streams. Lambdas are used only on functional interfaces where you can perform Intermediate and Terminate Operations. Functional interfaces can have as many as needed methods as long they are static and default and only one of them is abstract. Default methods are the one that you can provide implementation without the need of providing implementatio for them. There are a lot functional interfaces included in the standart API. If you need to use some of them you may have to check for the support in android.

This is how a proper non-spagetti code should look like! It have a good architecture a slight defects here and there which can be fixed but i wanted to share my knowlege with the rest and see how they can manage to fix this if they can actually see the problems. This project contains a proper Dagger2 implementation and a good MVP architecture which can be easy maintained and tested.

In the project you have Firebase login and some data from the firebase app. It can be a good step for someone that is just getting in to these libraries and into the android world.

If you decide to use RxJava don't forget to unsubscribe and make sure to make a subscription since you will understand what will happen if you don't :) simply your observable will just push or request data while there is none.

Project not Running? 

- There may be some problems on older emulators which doesn't support Google Play Services 10+ if you have them simply test on a real device or wait for the update from google!

Project Structure? Updated for the latest 2.8 libs

- Component and Module -> Dagger2 -> DI
- Presenter -> Presentation Layer
- Activity -> View Layer
- Iterator and Model classes -> Model Layer

Using Parcelable? - these are just a couple ways to pass data between your activities

- Yes we are using Parcelable since it is specificly made for Android rather than the slow Serilizalable. If you want to read more on the topic you can go and find what marshaling and unmarshaling means in Java.

Removed transitions?

- Yes there is no need for any animations that's why we remove them completely. Any diffrence between this and a fragment? Answer that one by yourself.

Want to remove the white screen on the beggining of the app?

- Well you have to create a proper Splash Screen one that doesn't involve Threads ^^
- There is a good guide how to do that it is simple and you don't have to remove the preview of the activity since it is an important part of your app lifecycle.

Toasts vs Snackbar?

- You can see for your self if you use Toasts and don't manage them properly you will completely destroy the user experience. There is a lot more to this if you sit and check what is actually happening. Snackbar have support for almoust every API out there i simply suggest that you use it. And it has a good vibe on it ^^

Checking if the user is logged?

- There you go the level is D:LoginActivity and you can follow onAuthStateChanged:signed_in or onAuthStateChanged:signed_out. The rest i leave to you.

Why Firebase?

- Firebase is one of the best out there and i think is one of the most powerful, secure and wth a lot of tools and it is lightning fast too. But there are some weird stuff going on in the debugger? Well there are you know google as i do. Just Update the libs to latest and don't pay that much attention to their logs. Other than that it works really great! And it is cross platform. You have everything you may need in an app. I will leave you to look it yourself and find all the awesome tools you may use.

#### Author

- Niki Izvorski (nikiizvorski@gmail.com)

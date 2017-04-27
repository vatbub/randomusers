# randomusers
This library generates random user data (just like Lorem ipsum but with people). The idea (and data) originates from [RandomAPI/Randomuser.me-Node](https://github.com/RandomAPI/Randomuser.me-Node) and I decided to do a complete Java implementation of it. It currently supports all the features of [randomuser.me](https://randomuser.me/) except for avatar images, but this is in the works.
 
 # Download
 Yay, it's on Maven central! You only need to specify this dependency in your pom to get the jar:
 ```xml
 <dependencies>
    <dependency>
      <groupId>com.github.vatbub</groupId>
      <artifactId>randomusers</artifactId>
      <version>1.0</version>
    </dependency>
</dependencies>
 ```
 
 If you don't use maven or gradle, you can download the latest jar [here](https://bintray.com/vatbub/fokprojectsReleases/randomusers#downloads).
 
 Contrary to [randomuser.me](https://randomuser.me/), this library works completely offline meaning that you need no more internet connection once you downloaded the jar.
 
 # Usage
 To get one single user which is completely random, just call
 ```java
 RandomUser user = Generator.generateRandomUser(new RandomUser.RandomUserSpec());
 ```
 
 If you wish to generate more than one user at once, you can call
 ```java
 int numberOfResultsToGenerate = 100;
 List<RandomUser> users = Generator.generateRandomUsers(new RandomUser.RandomUserSpec(), numberOfResultsToGenerate);
 ```
 This will result in one (or more) `RandomUser`-objects being generated. Those `RandomUser`-objects will contain the info about them (like their name, their email address ...). 
 
 If you wish to have more control over the result, you can modify the `RandomUserSpec`-object by calling one of its `set`-methods:
   - `setGenders(List<Gender> genders)` will force the generated users to have one of the genders listed in that list
   - `setNationalities(List<Nationality> nationalities)` will force the generated users to have one of the nationalities listed in that list
   - `setPasswordSpec(PasswordSpec passwordSpec)` specifies how the login passwords are generated (see more below)
   - `setSeed(long seed)` Using the same seed across multiple calls to the Generator will always result in the same user (if you use `generateRandomUser(...)`) or the same list of users (if you use `generateRandomUsers(...)`)
 For all parameters that you did not set using one of those setters, random values are generated. That means that if you specify a gender using `spec.setGenders(Arrays.asList(Gender.female))` but do not specify any nationalities, the generated users will all be female with a random nationality.

# How passwords are generated
By default, the login passwords created for the users consist of two words and a random number from 100 to 999. However, you may wish to control how passwords are generated. In that case, just create a `PasswordSpec`-object like this:
```java
PasswordSpec passwordSpec = new PasswordSpec();
passwordSpec.setMinLength(5);
passwordSpec.setMaxLength(10);
passwordSpec.setCharsest(Arrays.asList(PasswordCharset.special, PasswordCharset.number));
```
and add it to the `RandomUserSpec`-object using the `randomUserSpec.setPasswordSpec(...)`-method.

This example will result in passwords having a minimal length of 5 characters and a maximal length of 10 characters. The password will only contain special characters and numbers.
The following charsets are available:
- `PasswordCharset.special = !"#$%&'()*+,- ./:;<=>?@[\]^_``{|}~ `
- `PasswordCharset.upper = ABCDEFGHIJKLMNOPQRSTUVWXYZ`
- `PasswordCharset.lower = abcdefghijklmnopqrstuvwxyz`
- `PasswordCharset.number = 0123456789`
   

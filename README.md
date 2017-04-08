Java Heterogeneous Map
===========

Example of a heterogeneous map in Java. For each key the type of the value is known.

```java
with(
   HMap.put(Key::<cake>$, "Simnel")
       .put(Key::<_3>$, new BlindMice())
       .put(Key::<fantastic>$, 4),

   map -> {
       String cakeName = map.get(() -> Key.<cake>$()) ;  // While intellij thinks this can be replaced with a cleaner method reference, Javac disagrees :(
       assertEquals("Simnel", cakeName);

       int howMany = map.get(() -> Key.<fantastic>$()) ;
       assertEquals(4, howMany);

       BlindMice blindMice = map.get(() -> Key.<_3>$());
       assertNotNull(blindMice);

       // int a = map.get(() -> Key.<_3>$()); // wouldn't compile
   }
);
```
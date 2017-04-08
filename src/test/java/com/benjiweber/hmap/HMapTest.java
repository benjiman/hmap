package com.benjiweber.hmap;

import com.benjiweber.hmap.HMap.Key;
import org.junit.Test;

import static com.benjiweber.hmap.HMapTest.English.*;
import static com.benjiweber.hmap.HMapTest.NaturalNumbers.*;
import static com.benjiweber.hmap.With.with;
import static org.junit.Assert.*;

public class HMapTest {

    @Test
    public void hmap_example() {
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
    }


    interface English {
        interface cake {}
        interface fantastic{}
    }

    interface NaturalNumbers {
        interface _1 {}
        interface _2 {}
        interface _3 {}
    }

    class BlindMice {
        public String toString() {
            return getClass().getSimpleName();
        }
    } 
}
package com.benjiweber.hmap;


public interface HMap {

    static <K1, V1> HMap1<K1, V1> put(HMap1.HKey1<K1> key, V1 val) {
        return k -> val;
    }

    class Key {
        static <T> T $() {
            return null;
        }
    }

    interface HMap1<K1, V1> {
        interface HKey1<T> { T key(); }

        V1 get(HKey1<K1> key);
        default <K2, V2> HMap2<K1, V1, K2, V2> put(HMap2.HKey2<K2> key, V2 val) {
            return new HMap2<K1, V1, K2, V2>() {
                public V1 get(HKey1<K1> key) { return HMap1.this.get(key);}
                public V2 get(HKey2<K2> key) { return val; }
            };
        }
    }


    interface HMap2<K1, V1, K2, V2> {
        interface HKey2<T> { T key(); }

        V1 get(HMap1.HKey1<K1> key);
        V2 get(HKey2<K2> key);

        default <K3, V3> HMap3<K1, V1, K2, V2, K3, V3> put(HMap3.HKey3<K3> key, V3 val) {
            return new HMap3<K1, V1, K2, V2, K3, V3>() {
                public V1 get(HMap1.HKey1<K1> key) { return HMap2.this.get(key); }
                public V2 get(HKey2<K2> key) { return HMap2.this.get(key); }
                public V3 get(HKey3<K3> key) { return val; }
            };
        }
    }

    interface HMap3<K1, V1, K2, V2, K3, V3> {
        interface HKey3<T> { T key(); }

        V1 get(HMap1.HKey1<K1> key);
        V2 get(HMap2.HKey2<K2> key);
        V3 get(HMap3.HKey3<K3> key);
    }




}

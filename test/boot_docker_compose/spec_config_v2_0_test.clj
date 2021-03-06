(ns boot-docker-compose.spec-config-v2-0-test
  (:require [clojure.walk :as walk]
            [clojure.spec :as s]
            [clojure.spec.gen :as gen]
            [clojure.test.check.clojure-test :refer :all]
            [clojure.test.check.properties :as prop]
            [boot-docker-compose.spec-config-v2-0 :refer :all]))

(defspec service-valid? 100
  (prop/for-all [x (s/gen :boot-docker-compose.spec-config-v2-0/service)]
    (s/valid? :boot-docker-compose.spec-config-v2-0/service x)))

(defspec ipam-valid? 100
  (prop/for-all [x (s/gen :boot-docker-compose.spec-config-v2-0/ipam)]
    (s/valid? :boot-docker-compose.spec-config-v2-0/ipam x)))

(defspec network-valid? 100
  (prop/for-all [x (s/gen :boot-docker-compose.spec-config-v2-0/network)]
    (s/valid? :boot-docker-compose.spec-config-v2-0/network x)))

(defspec volume-valid? 100
  (prop/for-all [x (s/gen :boot-docker-compose.spec-config-v2-0/volume)]
    (s/valid? :boot-docker-compose.spec-config-v2-0/volume x)))

(defspec config-key-valid? 100
    (prop/for-all [x (s/gen :boot-docker-compose.spec-config-v2-0/config-key)]
      (s/valid? :boot-docker-compose.spec-config-v2-0/config-key x)))

(defspec spec-config-valid? 10 ; TODO where is the bottleneck?
  (prop/for-all [x (s/gen :boot-docker-compose.spec-config-v2-0/spec-config)]
    (s/valid? :boot-docker-compose.spec-config-v2-0/spec-config x)))

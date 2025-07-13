#!/usr/bin/env bb
;; NILFS2 Extension for Apple Container Framework

(require '[apple.container.core :as container])

;; NILFS2-specific container configuration
(def nilfs2-config
  {:container {:name "nilfs2-service"
               :image "ubuntu:24.04"
               :resources {:cpu 6 :memory "16g" :storage "100GB"}
               :filesystem {:type "nilfs2"
                           :mount-points ["/data" "/logs"]
                           :options ["continuous-checkpoint"]}}
   :apple-silicon {:optimizations {:vm-per-container true
                                  :hardware-acceleration true
                                  :filesystem-optimized true}}
   :state {:snapshots-enabled true
           :filesystem-snapshots true
           :retention-policy {:continuous 100 :hourly 24}}})

(defn deploy-nilfs2-service []
  (println "🗂️ Deploying NILFS2 optimized service...")
  (container/deploy-service nilfs2-config))

;; Export extension
{:deploy-nilfs2-service deploy-nilfs2-service
 :nilfs2-config nilfs2-config}
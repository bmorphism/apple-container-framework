#!/usr/bin/env bb
;; Example: Simple Web Server with Apple Container Framework

(require '[apple.container.core :as container]
         '[apple.container.health :as health]
         '[apple.container.performance :as performance]
         '[apple.container.state :as state])

;; Web service configuration
(def web-service-config
  {:container {:name "nginx-web-service"
               :image "nginx:alpine"
               :ports ["80:8080" "443:8443"]
               :volumes ["web-content:/usr/share/nginx/html"]
               :resources {:cpu 2
                          :memory "2g"
                          :storage "10GB"}}
   :health {:checks [:basic-connectivity :http-health]
            :interval 30
            :recovery-strategy :restart}
   :performance {:monitoring-enabled true
                :benchmark-workloads [:startup :memory-efficiency]}
   :state {:snapshots-enabled true
           :retention-policy {:auto 10 :daily 5}}
   :apple-silicon {:optimizations {:vm-per-container true
                                  :hardware-acceleration true}}})

;; Deployment workflow
(defn deploy-web-service []
  (println "🚀 Deploying web service with Apple Container Framework...")
  
  ;; Create container manager
  (let [manager (container/create-manager web-service-config)]
    
    ;; Complete deployment workflow
    (println "📋 Checking prerequisites...")
    (container/check-prerequisites manager)
    
    (println "🔧 Creating resources...")
    (container/create-resources manager (:config manager))
    
    (println "📦 Deploying container...")
    (container/deploy-container manager web-service-config)
    
    (println "🏥 Verifying health...")
    (container/verify-health manager)
    
    (println "🎉 Web service deployment complete!")
    (println "📍 Service available at: http://localhost:8080")
    
    manager))

;; CLI interface
(let [command (first *command-line-args*)]
  (case command
    "deploy" (deploy-web-service)
    "status" (println "Status check not implemented yet")
    "benchmark" (println "Benchmark not implemented yet")
    
    ;; Default: show usage
    (do
      (println "🍎 Apple Container Framework - Web Service Example")
      (println)
      (println "Usage:")
      (println "  bb deploy.bb deploy     - Deploy the web service")
      (println "  bb deploy.bb status     - Check service status")
      (println "  bb deploy.bb benchmark  - Run performance tests")
      (println)
      (println "Example:")
      (println "  bb deploy.bb deploy"))))
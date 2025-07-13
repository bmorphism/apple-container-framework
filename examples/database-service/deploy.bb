#!/usr/bin/env bb
;; Example: Database Service with Snapshots

(require '[apple.container.core :as container]
         '[apple.container.state :as state])

;; PostgreSQL service configuration
(def database-config
  {:container {:name "postgres-database"
               :image "postgres:16-alpine"
               :ports ["5432:5432"]
               :volumes ["postgres-data:/var/lib/postgresql/data"]
               :env-vars {"POSTGRES_DB" "myapp"
                         "POSTGRES_USER" "admin"
                         "POSTGRES_PASSWORD" "secure123"}
               :resources {:cpu 4
                          :memory "8g"
                          :storage "50GB"}}
   :health {:checks [:basic-connectivity :database-health]
            :interval 60
            :recovery-strategy :restart-with-snapshot}
   :state {:snapshots-enabled true
           :retention-policy {:auto 24 :daily 7 :weekly 4}
           :schedule {:hourly true}}
   :apple-silicon {:optimizations {:vm-per-container true
                                  :hardware-acceleration true
                                  :memory-pressure-aware true}}})

(defn deploy-database []
  (println "🗄️ Deploying PostgreSQL database...")
  (let [manager (container/deploy-service database-config)]
    (println "✅ Database deployed successfully")
    (println "📊 Connection: localhost:5432")
    (println "💾 Snapshots: Enabled with hourly schedule")
    manager))

;; CLI interface
(let [command (first *command-line-args*)]
  (case command
    "deploy" (deploy-database)
    "snapshot" (println "Manual snapshot creation")
    
    ;; Default: show usage
    (println "Usage: bb deploy.bb [deploy|snapshot]")))
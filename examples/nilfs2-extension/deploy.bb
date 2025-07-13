#!/usr/bin/env bb
;; NILFS2 Extension Example

(load-file "src/nilfs2/container/core.bb")

(let [command (first *command-line-args*)]
  (case command
    "deploy" (deploy-nilfs2-service)
    (println "Usage: bb deploy.bb deploy")))
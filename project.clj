(defproject snakey "0.1.0"
  :description "Yet Another Snake clone, this time in Clojure."
  :url "https://github.com/saxonmatt/Snakey"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :main snakey.core
  :profiles {:uberjar {:aot :all}})

(ns kotoba.lsp-rpc.read-content-length
  "read-content-length -- addressed on its own.

  Split out of kotoba.lang.lsp-rpc on 2026-09-09 (ADR-2609091200). The unit
  here is the DEFINITION, and this repo's deps.edn names exactly the
  definitions it reaches -- nothing else.
"
  )

(defn read-content-length
  "Read Content-Length from a framed string. Returns [len header-len] or nil."
  [s]
  (when-let [m (re-find #"Content-Length:\s*(\d+)\r\n\r\n" s)]
    [(Long/parseLong (second m)) (count (first m))]))

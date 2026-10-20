# Cloudflare GraphQL via Infinity is shared on this Grafana Cloud stack with
# Block Drop (uid infinity-cloudflare / name "Cloudflare GraphQL"). Creating it
# here returns 409. Dashboard panels already reference that uid; set
# cloudflare_zone_tag so the Netrunner dashboard zone variable is populated.
# Keep cloudflare_analytics_token in Block Drop's grafana root (token owner).

# GitHub Actions / repo queries (no Alloy exporter).
# Plugin grafana-github-datasource must already be installed on the stack
# (Block Drop grafana root).
resource "grafana_data_source" "github" {
  count    = local.enable_github_ci ? 1 : 0
  provider = grafana.stack

  type = "grafana-github-datasource"
  name = "GitHub Netrunner"
  uid  = "github-netrunner"

  json_data_encoded = jsonencode({
    selectedAuthType = "personal-access-token"
  })

  secure_json_data_encoded = jsonencode({
    accessToken = var.github_access_token
  })
}

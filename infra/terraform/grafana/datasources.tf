# Infinity DS uid infinity-cloudflare is owned by https://github.com/7oas7er/platform
# (shared-obs). Do not recreate it here (409 Conflict on shared stack).
# Set cloudflare_zone_tag so the Netrunner dashboard zone variable is populated.

# GitHub Actions / repo queries. Plugin install is owned by platform shared-obs.
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

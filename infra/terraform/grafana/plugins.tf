# Grafana Cloud does not ship every catalog plugin by default. Without an
# install, a provisioned data source of that type is invisible in the UI
# ("No data sources found" on dashboard variables).
#
# Infinity (yesoreyeram-infinity-datasource) is pre-provisioned on this Cloud
# stack — do not install it via Terraform (API returns 409).
#
# This stack is shared with Block Drop. The GitHub plugin is installed/owned
# there; managing it here with version = "latest" forces destroy/recreate and
# 409s. Netrunner only needs the plugin present — create github-netrunner DS
# in datasources.tf without an install resource.

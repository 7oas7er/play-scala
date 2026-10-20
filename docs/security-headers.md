# Security headers

| Layer | Role |
|-------|------|
| **CloudFront** `aws_cloudfront_response_headers_policy.site` | **Source of truth** for viewer security headers (CSP, HSTS, Referrer-Policy, X-Frame-Options, X-Content-Type-Options, XSS-Protection, Permissions-Policy). Attached to the default cache behavior. |
| **Cloudflare** | DNS/proxy + origin-verify injection. Does **not** duplicate these response headers. |

## CSP (Netrunner)

Defined in `infra/terraform/aws/modules/site/locals.tf`:

- Same-origin scripts, images, connect (catalog JSON via `fetch`)
- `style-src` allows `https://fonts.googleapis.com`
- `font-src` allows `https://fonts.gstatic.com`
- No inline scripts; bump `?v=` on assets when JS/CSS change

Changing CSP or other headers requires a **local Terraform apply** on the AWS env roots before deploy can rely on the new policy.

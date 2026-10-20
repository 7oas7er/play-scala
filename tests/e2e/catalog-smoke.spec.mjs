import { expect, test } from "@playwright/test";

test.describe("Netrunner catalog", () => {
  test("loads the full catalog with a known card", async ({ page }) => {
    await page.goto("./");
    await expect(page.getByRole("heading", { name: "All Cards" })).toBeVisible();
    await expect(page.locator("#view-count")).toHaveText("580");
    await expect(page.getByRole("cell", { name: "Executive File Clerk" })).toBeVisible();
  });

  test("generates a 60-card Runner starter", async ({ page }) => {
    await page.goto("./?view=starter-runner");
    await expect(page.getByRole("heading", { name: "Runner Starter" })).toBeVisible();
    await expect(page.locator("#view-count")).toHaveText("60");
    await expect(page.locator("#selection-ids")).toBeVisible();
    const ids = await page.locator("#ids-text").innerText();
    expect(ids.split(",")).toHaveLength(60);
  });

  test("generates a Proteus booster from Proteus cards", async ({ page }) => {
    await page.goto("./?view=booster-proteus");
    await expect(page.getByRole("heading", { name: "Proteus Booster" })).toBeVisible();
    await expect(page.locator("#view-count")).toHaveText("15");
    const editions = await page.locator("#cards-table tbody tr td:nth-child(10)").allTextContents();
    expect(editions).toHaveLength(15);
    for (const edition of editions) {
      expect(edition).toBe("Proteus");
    }
  });

  test("imprint page is reachable", async ({ page }) => {
    await page.goto("./imprint.html");
    await expect(page.getByRole("heading", { name: "Impressum" })).toBeVisible();
  });
});

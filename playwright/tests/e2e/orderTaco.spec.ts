import { expect, test } from "@playwright/test";

test.describe('Taco Cloud', () => {
    test('should allow a user to order a taco', async ({ page }) => {
        await page.goto('http://localhost:8080');
        await expect(page.getByRole('heading', {name: 'Welcome to...', exact: true})).toBeVisible();
        await expect(page.getByText('Taco design starts here')).toBeVisible();
        await page.getByRole('link', { name: 'New design', exact: true }).click();

        // Design taco
        await expect(page.getByRole('heading', { name: 'Design your taco!', exact: true })).toBeVisible();
        await page.check('input[name="ingredients"][value="COTO"]');
        await page.check('input[name="ingredients"][value="GRBF"]');
        await page.check('input[name="ingredients"][value="CHED"]');
        await page.check('input[name="ingredients"][value="LETC"]');
        await page.check('input[name="ingredients"][value="SLSA"]');
        await page.locator('input[id="name"]').fill('Taco001');
        await page.getByRole('button', { name: 'Submit Your Taco', exact: true }).click();

        // Place order
        await expect(page.getByRole('heading', { name: 'Order your taco creations!', exact: true })).toBeVisible();
        await page.locator('input[id="deliveryName"]').fill('Luitech Limited');
        await page.locator('input[id="deliveryStreet"]').fill('1 Solander Place');
        await page.locator('input[id="deliveryCity"]').fill('Porirua');
        await page.locator('input[id="deliveryState"]').fill('Wellington');
        await page.locator('input[id="deliveryZip"]').fill('5024');
        await page.locator('input[id="ccNumber"]').fill('4111111111111111');
        await page.locator('input[id="ccExpiration"]').fill('12/26');
        await page.locator('input[id="ccCVV"]').fill('202');
        await page.getByRole('button', { name: 'Submit Order', exact: true }).click();

        // Should return to home page
        await expect(page.getByRole('heading', {name: 'Welcome to...', exact: true})).toBeVisible();
    })
})

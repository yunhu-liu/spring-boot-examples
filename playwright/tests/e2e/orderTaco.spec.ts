import { expect, test } from "@playwright/test";

test.describe('Taco Cloud', () => {
    test('should allow a user to order a taco', async ({ page }) => {
        await page.goto('http://localhost:8080');

        // Login steps using test IDs and existing elements
        await expect(page.getByRole('heading', { name: 'Login'})).toBeVisible();
        await page.getByTestId('username').fill('admin');
        await page.getByTestId('password').fill('password');
        await page.getByTestId('login-button').click();

        // Check for the correct landing page heading to verify successful login
        await expect(page.getByRole('heading', { name: 'Welcome to...', level: 1 })).toBeVisible();

        // Existing test steps continue from here
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
        await expect(page.locator('input[id="deliveryName"]')).toHaveValue('Admin User');
        await expect(page.locator('input[id="deliveryStreet"]')).toHaveValue('123 Admin St');
        await expect(page.locator('input[id="deliveryCity"]')).toHaveValue('Admin City');
        await expect(page.locator('input[id="deliveryState"]')).toHaveValue('AD');
        await expect(page.locator('input[id="deliveryZip"]')).toHaveValue('12345');
        await page.locator('input[id="ccNumber"]').fill('4111111111111111');
        await page.locator('input[id="ccExpiration"]').fill('12/26');
        await page.locator('input[id="ccCVV"]').fill('202');
        await page.getByRole('button', { name: 'Submit Order', exact: true }).click();

        // Should return to home page
        await expect(page.getByRole('heading', {name: 'Welcome to...', exact: true})).toBeVisible();
    })
})

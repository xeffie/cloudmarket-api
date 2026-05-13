const API_BASE_URL = "https://linb6iy2ql.execute-api.eu-north-1.amazonaws.com";

const form = document.getElementById("listingForm");
const listingsContainer = document.getElementById("listings");

form.addEventListener("submit", async function (event) {
    event.preventDefault();

    try {
        const imageInput = document.getElementById("image");
        const imageFile = imageInput.files[0];

        let imageKey = null;

        if (imageFile) {
            imageKey = await uploadImage(imageFile);
        }

        const listing = {
            title: document.getElementById("title").value,
            description: document.getElementById("description").value,
            price: Number(document.getElementById("price").value),
            category: document.getElementById("category").value,
            itemCondition: document.getElementById("itemCondition").value,
            sellerName: document.getElementById("sellerName").value,
            status: document.getElementById("status").value,
            imageKey: imageKey
        };

        const response = await fetch(`${API_BASE_URL}/api/listings`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(listing)
        });

        if (!response.ok) {
            throw new Error("Failed to create listing");
        }

        form.reset();
        await loadListings();
    } catch (error) {
        alert(error.message);
    }
});

function fileToBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();

        reader.onload = () => {
            const result = reader.result;
            const base64 = result.split(",")[1];
            resolve(base64);
        };

        reader.onerror = reject;
        reader.readAsDataURL(file);
    });
}

async function uploadImage(file) {
    const base64Image = await fileToBase64(file);

    const response = await fetch(`${API_BASE_URL}/upload`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            fileName: file.name,
            contentType: file.type,
            image: base64Image
        })
    });

    if (!response.ok) {
        throw new Error("Image upload failed");
    }

    const data = await response.json();
    return data.key;
}

async function getImageUrl(imageKey) {
    if (!imageKey) {
        return null;
    }

    const response = await fetch(`${API_BASE_URL}/download?key=${encodeURIComponent(imageKey)}`);

    if (!response.ok) {
        return null;
    }

    const data = await response.json();
    return data.downloadUrl;
}

async function loadListings() {
    try {
        const response = await fetch(`${API_BASE_URL}/api/listings`);

        if (!response.ok) {
            throw new Error("Failed to load listings");
        }

        const listings = await response.json();

        listingsContainer.innerHTML = "";

        if (listings.length === 0) {
            listingsContainer.innerHTML = "<p>No listings found.</p>";
            return;
        }

        for (const listing of listings) {
            const imageUrl = await getImageUrl(listing.imageKey);

            const card = document.createElement("div");
            card.className = "listing-card";

            card.innerHTML = `
                <button class="card-delete-button" onclick="deleteListing(${listing.id})" aria-label="Delete listing">
                    ×
                </button>

                ${
                imageUrl
                    ? `<img src="${imageUrl}" alt="${listing.title}" class="listing-image">`
                    : `<div class="listing-image placeholder">No image</div>`
            }

                <h3>${listing.title}</h3>
                <p>${listing.description || "No description"}</p>
                <p><strong>Price:</strong> ${listing.price} kr</p>
                <p><strong>Category:</strong> ${listing.category}</p>
                <p><strong>Condition:</strong> ${listing.itemCondition}</p>
                <p><strong>Seller:</strong> ${listing.sellerName}</p>
                <span class="badge">${listing.status}</span>
            `;

            listingsContainer.appendChild(card);
        }
    } catch (error) {
        listingsContainer.innerHTML = `<p>${error.message}</p>`;
    }
}

async function deleteListing(id) {
    try {
        const response = await fetch(`${API_BASE_URL}/api/listings/${id}`, {
            method: "DELETE"
        });

        if (!response.ok) {
            throw new Error("Failed to delete listing");
        }

        await loadListings();
    } catch (error) {
        alert(error.message);
    }
}

loadListings();
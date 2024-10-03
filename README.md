# Fetch Rewards Challenge
Watch the demo video here [Youtube](https://youtube.com/shorts/x-ELDxf7rIk?feature=share) 

Watch the demo video for the empty state pull to refresh here [Youtube](https://youtube.com/shorts/qb9BtNOI4SQ?feature=share)

## Overview

This built using Jetpack Compose. It fetches and displays a list of items from the provided API, allowing users to switch between different tabs using List ID's and refresh the list via a pull-to-refresh feature. The app also utilizes Room for local data storage, to reduce API usage.

## Features

- **Tabbed Navigation**: Users can switch between different item categories, using the List ID
- **Pull-to-Refresh**:  Refresh the item list by pulling down, getting the latest items from the api
- **Offline Support**: Uses Room database to cache data and enhance performance.
- **Loading States**: Displays loading indicators while fetching data from the API, using a Shimmer library.

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Koin**
- **Retrofit**
- **Room**

## Getting Started

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/compose-item-list-app.git

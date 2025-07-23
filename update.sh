#!/bin/bash

# Add all changes
git add .

# Commit with a generic daily update message
# The $(date) part adds the current date and time to the message
git commit -m "chore: Daily update $(date)"

# Push the changes to GitHub
git push origin main

echo "✅ Project updated and pushed to GitHub!"

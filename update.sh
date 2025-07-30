#!/bin/bash

# Check if a commit message was provided
if [ -z "$1" ]; then
  echo "🛑 Error: You must provide a commit message."
  echo "Usage: sh update.sh \"Your descriptive message\""
  exit 1
fi

# Add, commit, and push
git add .
git commit -m "$1"
git push

echo "✅ Successfully committed and pushed to GitHub!"













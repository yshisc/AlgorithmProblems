import os

def traverseDirByShell():
    path = os.path.expanduser(".")
    for f in os.listdir(path):
        os.rename(f, "No" + f[0:3] + f[4:])

traverseDirByShell()